package com.homepage.careerdoctor.post.service;

import com.homepage.careerdoctor.domain.Post;
import com.homepage.careerdoctor.domain.User;
import com.homepage.careerdoctor.domain.Vote;
import com.homepage.careerdoctor.post.dto.*;
import com.homepage.careerdoctor.post.repostitory.PostRepository;
import com.homepage.careerdoctor.user.repository.UserRepository;
import com.homepage.careerdoctor.util.response.CustomApiResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override // 게시글(투표글) 작성
    public ResponseEntity<CustomApiResponse<?>> writePost(PostWriteRequestDto requestDto) {
        // 댓글 작성자가 db에 존재하는가?
        Optional<User> findUser = userRepository.findByUserId(requestDto.getUserId());

        // 존재하지 않는다면 오류 리턴하는 로직 추가
        if (findUser.isEmpty()) {
            return ResponseEntity.status(404)
                    .body(CustomApiResponse.createFailWithoutData(404, "존재하지 않는 사용자입니다."));
        }

        // 존재한다면 게시글 db에 저장
        Post newPost = Post.builder()
                .postTitle(requestDto.getPostTitle())
                .postContent(requestDto.getPostContent())
                .user(findUser.get())
                .build();

        List<VoteDto> voteDtos = requestDto.getVote();

        List<Vote> votes = voteDtos.stream()
                .map(voteDto -> Vote.builder()
                        .voteContent(voteDto.getVoteTitle())
                        .voteCount(voteDto.getVoteCount())
                        .post(newPost)
                        .build())
                .collect(Collectors.toList());


        newPost.changeVote(votes);
        postRepository.save(newPost);


        // 응답으로 넘겨줄 dto
        PostWriteResponeDto responseDto = PostWriteResponeDto.builder()
                .postId(newPost.getPostId())
                .createdAt(newPost.getCreatedAt())
                .build();

        return ResponseEntity.status(201)
                .body(CustomApiResponse.createSuccess(201, responseDto, "게시글을 성공적으로 작성했습니다."));
    }

    @Override
    public ResponseEntity<CustomApiResponse<?>> getPosts() {
        List<Post> posts = postRepository.findAll();

        List<PostListDto.PostResponse> postResponses = new ArrayList<>();
        for (Post post : posts) {
            postResponses.add(PostListDto.PostResponse.builder()
                    .userId(post.getUser().getUserId())
                    .postTitle(post.getPostTitle())
                    .postContent(post.getPostContent())
                    .createdAt(post.getCreatedAt())
                    .vote(post.getVotes())
                    .likeCount(post.getLikeds().size())
                    .scrapCount(post.getScraps().size())
                    .build());
        }
        // 사용자에게 반환하기위한 최종 데이터
        return ResponseEntity.status(201)
                .body(CustomApiResponse.createSuccess(201, postResponses, "게시글 목록을 성공적으로 불러왔습니다."));
    }

    // 내가 올린 게시글 목록 보기
    @Override
    public ResponseEntity<CustomApiResponse<?>> getMyPost(String userId) {
        // 모든 게시글을 가져온다.
        List<Post> allPost = postRepository.findAll();

        // 저장할 post 리스트
        List<PostListDto.PostResponse> myPostResponses = new ArrayList<>();

        // 게시물들의 유저 아이디가 현재 유저 아이디와 일치한다면 리스트에 저장한다.
        for (int i = 0; i < allPost.size(); i++) {
            if (allPost.get(i).getUser().getUserId().equals(userId)) {
                myPostResponses.add(PostListDto.PostResponse.builder()
                                .postTitle(allPost.get(i).getPostTitle())
                                .postContent(allPost.get(i).getPostContent())
                                .createdAt(allPost.get(i).getCreatedAt())
                                .vote(allPost.get(i).getVotes())
                        .build());
            }
        }

        return ResponseEntity.status(201)
                .body(CustomApiResponse.createSuccess(201, myPostResponses, "내가 작성한 게시글 목록을 성공적으로 불러왔습니다."));
    }

    @Override
    public ResponseEntity<CustomApiResponse<?>> modifyPost(String userId, Long postId, PostModifyRequestDto.Req req) {
        // 게시글 작성자와 현재 유저가 다른 사람일 경우
        Long memberId = postRepository.findByPostId(postId).get().getUser().getMemberId();
        String findUserId = userRepository.findById(memberId).get().getUserId();

        if (!(findUserId.equals(userId))) {
            return ResponseEntity.status(403)
                    .body(CustomApiResponse.createFailWithoutData(403, "게시글은 본인만 수정할 수 있습니다."));
        }

        // 게시글 찾기
        Optional<Post> findPost = postRepository.findByPostId(postId);

        // 게시글 업데이트
        Post post = findPost.get();
        post.changeTitle(req.getPostTitle());
        post.changeContent(req.getPostContent());
        postRepository.flush();

        PostModifyRequestDto.ModifyPost modifyPost = new PostModifyRequestDto.ModifyPost(post.getUpdatedAt());

        return ResponseEntity.status(201)
                .body(CustomApiResponse.createSuccess(201, modifyPost, "게시글 수정을 완료했습니다."));
    }

    @Override
    public ResponseEntity<CustomApiResponse<?>> deletePost(PostDeleteRequestDto dto) {
        // 게시글이 존재하는지
        Optional<Post> findPost = postRepository.findByPostId(dto.getPostId());

        if (findPost.isEmpty()) {
            return ResponseEntity.status(404)
                    .body(CustomApiResponse.createFailWithoutData(404, "게시글이 존재하지 않습니다."));
        }

        // 현재 유저와 게시글 작성자가 같은지
        String postUserId = findPost.get().getUser().getUserId();

        if (!(postUserId.equals(dto.getUserId()))) { // 다르면
            return ResponseEntity.status(400)
                    .body(CustomApiResponse.createFailWithoutData(400, "게시글 작성자가 아닙니다."));

        }

        // 게시글 삭제

        postRepository.delete(findPost.get());

        return ResponseEntity.status(201)
                .body(CustomApiResponse.createSuccess(201, null, "게시글이 삭제되었습니다."));
    }
}
