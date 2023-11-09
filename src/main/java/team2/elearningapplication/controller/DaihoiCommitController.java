package team2.elearningapplication.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import team2.elearningapplication.Enum.ResponseCode;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.user.post.AddPostRequest;
import team2.elearningapplication.dto.response.user.post.AddPostResponse;

import javax.validation.Valid;

public class DaihoiCommitController {
    @PostMapping("/add-post")
    public ResponseEntity<ResponseCommon<AddPostResponse>> addPost(@Valid @RequestBody AddPostRequest addPostRequest) {
        ResponseCommon<AddPostResponse> response = postService.addPost(addPostRequest);
        if (response.getCode() == ResponseCode.SUCCESS.getCode()) {
            return ResponseEntity.ok(response);
        } else if (response.getCode() == ResponseCode.POST_CONTENT_IS_EMPTY.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(), "Post content is empty", null));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Add post failed", null));
        }
    }
    @PostMapping("/add-post")
    public ResponseEntity<ResponseCommon<AddPostResponse>> addPost(@Valid @RequestBody AddPostRequest addPostRequest) {
        ResponseCommon<AddPostResponse> response = postService.addPost(addPostRequest);
        if (response.getCode() == ResponseCode.SUCCESS.getCode()) {
            return ResponseEntity.ok(response);
        } else if (response.getCode() == ResponseCode.POST_CONTENT_IS_EMPTY.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(), "Post content is empty", null));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Add post failed", null));
        }
    }
    @PostMapping("/add-post")
    public ResponseEntity<ResponseCommon<AddPostResponse>> addPost(@Valid @RequestBody AddPostRequest addPostRequest) {
        ResponseCommon<AddPostResponse> response = postService.addPost(addPostRequest);
        if (response.getCode() == ResponseCode.SUCCESS.getCode()) {
            return ResponseEntity.ok(response);
        } else if (response.getCode() == ResponseCode.POST_CONTENT_IS_EMPTY.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(), "Post content is empty", null));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Add post failed", null));
        }
    }
    @PostMapping("/add-post")
    public ResponseEntity<ResponseCommon<AddPostResponse>> addPost(@Valid @RequestBody AddPostRequest addPostRequest) {
        ResponseCommon<AddPostResponse> response = postService.addPost(addPostRequest);
        if (response.getCode() == ResponseCode.SUCCESS.getCode()) {
            return ResponseEntity.ok(response);
        } else if (response.getCode() == ResponseCode.POST_CONTENT_IS_EMPTY.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(), "Post content is empty", null));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Add post failed", null));
        }
    }
    @PostMapping("/add-post")
    public ResponseEntity<ResponseCommon<AddPostResponse>> addPost(@Valid @RequestBody AddPostRequest addPostRequest) {
        ResponseCommon<AddPostResponse> response = postService.addPost(addPostRequest);
        if (response.getCode() == ResponseCode.SUCCESS.getCode()) {
            return ResponseEntity.ok(response);
        } else if (response.getCode() == ResponseCode.POST_CONTENT_IS_EMPTY.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(), "Post content is empty", null));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Add post failed", null));
        }
    }
}
