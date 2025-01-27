package dev.deerops.loginpagebe.common.util.result;

public class ResponseHelper {


    public static <T> ApiResponse<T> CREATE(T data){
        return new ApiResponse<>(true,"Created data",data);
    }

    public static <T> ApiResponse<T> SUCCESS(T data){
        return new ApiResponse<>(true,"Success",data);
    }
}
