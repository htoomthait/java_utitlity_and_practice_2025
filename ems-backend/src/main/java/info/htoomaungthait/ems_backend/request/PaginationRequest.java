package info.htoomaungthait.ems_backend.request;

import jakarta.validation.constraints.Min;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
public class PaginationRequest {
    @Min(1)
    private int page = 1;

    @Min(5)
    private int size = 10;

    private List<String> sort = List.of("id:desc", "name:asc");

    private final Logger logger = LoggerFactory.getLogger(PaginationRequest.class);


    /**
     * Converts the current pagination request into a Pageable object.
     * The sort parameter is expected to be in the format "field:direction",
     * where direction can be either "asc" or "desc". Its page start from 1.
     *
     * @author Htoo Maung Thait
     * @since 2025-06-21
     * @lastModified 2025-06-21
     * @return a Pageable object representing the pagination and sorting information.
     */
    public Pageable getPageable() {


        Sort sortBy = Sort.by(
                sort.stream().map(sortContent -> {
                    String[] sortInfo = sortContent.split(":");
                    Sort.Direction sortDirection = sortInfo[1].equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
                    return new Sort.Order(sortDirection, sortInfo[0]);
                }).toList()
        );


        return PageRequest.of(this.page - 1, this.size, sortBy);
    }

}
