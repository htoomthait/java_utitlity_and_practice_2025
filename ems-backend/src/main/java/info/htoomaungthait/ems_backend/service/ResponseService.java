package info.htoomaungthait.ems_backend.service;

import info.htoomaungthait.ems_backend.dto.ApiResponseV2;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface ResponseService<T> {

    ResponseEntity<ApiResponseV2<T>> createdSuccess(String message, T data);



    ResponseEntity<ApiResponseV2<T>> queriedSuccess(String message, T data);

    ResponseEntity<ApiResponseV2<Page<T>>> queriedPageSuccess(String message, Page<T> pageData);

    ResponseEntity<ApiResponseV2<T>> updatedSuccess(String message, T data);

    ResponseEntity<ApiResponseV2<T>> deletedSuccess(String message, T data);

    ResponseEntity<ApiResponseV2<T>> resourceEmpty(String message);

    ResponseEntity<ApiResponseV2<T>> resourceNotFound(String message);

    ResponseEntity<ApiResponseV2<T>> resourceConflict(String message);

    ResponseEntity<ApiResponseV2<T>> requestInvalid(String message);

    ResponseEntity<ApiResponseV2<T>> promptError(String message);

    ResponseEntity<ApiResponseV2<Page<T>>> promptErrorPage(String message);
}
