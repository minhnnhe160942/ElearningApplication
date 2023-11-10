package team2.elearningapplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import team2.elearningapplication.Enum.ResponseCode;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.category.AddCategoryRequest;
import team2.elearningapplication.dto.response.admin.category.AddCategoryResponse;
import team2.elearningapplication.service.ICategoryService;

import javax.validation.Valid;

public class CommentController {
    private ICategoryService categoryService;
    @PostMapping("/add-category")
    public ResponseEntity<ResponseCommon<AddCategoryResponse>> addCategory(@Valid @RequestBody AddCategoryRequest addCategoryRequest){
        ResponseCommon<AddCategoryResponse> response = categoryService.addCategory(addCategoryRequest);
        // if code response equals code Success -> return ok
        if(response.getCode() == ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code response equals code category exist -> return error
        else if(response.getCode() == ResponseCode.CATEGORY_EXIST.getCode()){
            return  ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseCommon<>(ResponseCode.CATEGORY_EXIST.getCode(),"Category already exist",null));
        } // else return fail
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"System error",null));
        }
    }@PostMapping("/add-category")
    public ResponseEntity<ResponseCommon<AddCategoryResponse>> addCategory(@Valid @RequestBody AddCategoryRequest addCategoryRequest){
        ResponseCommon<AddCategoryResponse> response = categoryService.addCategory(addCategoryRequest);
        // if code response equals code Success -> return ok
        if(response.getCode() == ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code response equals code category exist -> return error
        else if(response.getCode() == ResponseCode.CATEGORY_EXIST.getCode()){
            return  ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseCommon<>(ResponseCode.CATEGORY_EXIST.getCode(),"Category already exist",null));
        } // else return fail
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"System error",null));
        }
    }
}
