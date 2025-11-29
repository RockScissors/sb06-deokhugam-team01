package com.sprint.sb06deokhugamteam01.dto.comment.request;

import com.sprint.sb06deokhugamteam01.enums.SortDirection;
import org.springframework.data.domain.Sort;

import java.util.UUID;

public record CommentListRequest(
        UUID reviewId,
        Sort.Direction direction,

) {
}
