package com.hero.SchoolHub.util.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

    private T data;

    private Integer code;

    private Long allRecords;

    private String message;

    private Boolean success= true;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Response)) return false;
        Response<?> response = (Response<?>) o;
        return Objects.equals(getData(), response.getData()) &&
                Objects.equals(getCode(), response.getCode()) &&
                Objects.equals(getAllRecords(), response.getAllRecords()) &&
                Objects.equals(getMessage(), response.getMessage()) &&
                Objects.equals(getSuccess(), response.getSuccess());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getData(), getCode(), getAllRecords(), getMessage(), getSuccess());
    }
}
