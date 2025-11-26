package com.sprint.sb06deokhugamteam01.repository.review;

import com.sprint.sb06deokhugamteam01.domain.Review;
import com.sprint.sb06deokhugamteam01.dto.review.CursorPagePopularReviewRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.time.LocalDateTime;
import java.util.UUID;

public interface ReviewRepositoryCustom {

    Slice<Review> getReviews(
            UUID userId,
            UUID bookId,
            String keyword,
            boolean ascending,
            boolean useRating,
            String cursor,
            LocalDateTime after,
            Integer limit,
            Pageable pageable
    );

    Slice<Review> getPopularReviews(
            CursorPagePopularReviewRequest.RankCriteria period,
            boolean descending,
            String cursor,
            LocalDateTime after,
            Integer limit,
            Pageable pageable
    );
}
