package com.sprint.sb06deokhugamteam01.service;

import com.sprint.sb06deokhugamteam01.domain.Comment;
import com.sprint.sb06deokhugamteam01.domain.Review;
import com.sprint.sb06deokhugamteam01.domain.User;
import com.sprint.sb06deokhugamteam01.dto.CommentCreateRequest;
import com.sprint.sb06deokhugamteam01.dto.CommentDto;
import com.sprint.sb06deokhugamteam01.dto.CommentUpdateRequest;
import com.sprint.sb06deokhugamteam01.repository.CommentRepository;
import com.sprint.sb06deokhugamteam01.repository.ReviewRepository;
import com.sprint.sb06deokhugamteam01.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.nio.file.AccessDeniedException;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CommentServiceTest {
    @Mock
    private CommentRepository commentRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private CommentService commentService;


    // TODO: Easy Random 사용... 추후 변경
    @Test
    @DisplayName("댓글 등록 성공")
    void createComment_Success(){
        // given
        UUID userId = UUID.randomUUID();
        UUID reviewId = UUID.randomUUID();
        User user = User.builder().id(userId).nickname("유저").build();
        Review review = Review.builder().id(reviewId).build();
        Comment comment = Comment.builder().user(user).review(review).build();

        CommentCreateRequest request = new CommentCreateRequest(reviewId, userId, "댓글");
        given(userRepository.findById(userId)).willReturn(Optional.of(user));
        given(reviewRepository.findById(reviewId)).willReturn(Optional.of(review));
        given(commentRepository.save(any(Comment.class))).willReturn(comment);

        // when
        CommentDto result = commentService.createComment(request);

        // then
        assertThat(result).isNotNull();
        assertThat(result.content()).isEqualTo("댓글");
        assertThat(result.userNickname()).isEqualTo("유저");
        verify(commentRepository).save(any(Comment.class));
    }

    @Test
    @DisplayName("존재하지 않는 유저로 댓글 등록 시도 시 실패")
    void createComment_WithNotExistentUser_ThrowException(){
        // given

        // when

        // then
    }
    @Test
    @DisplayName("존재하지 않는 리뷰로 댓글 등록 시도 시 실패")
    void createComment_WithNotExistentReview_ThrowException(){
        // given

        // when

        // then

    }

    // 테스트 편의용 팩토리 메소드
    private User createUser() {
        return User.builder().id(UUID.randomUUID()).nickname("테스트유저").build();
    }
    private Review createReview() {
        return Review.builder().id(UUID.randomUUID()).build();
    }
    private Comment createSavedComment(User user, Review review, String content){
        return Comment.builder().user(user).review(review)
                .content(content).build();
    }
}
