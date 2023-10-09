package team2.elearningapplication.service.implement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import team2.elearningapplication.Enum.ResponseCode;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.category.AddCategoryRequest;
import team2.elearningapplication.dto.request.admin.category.DeleteCategoryRequest;
import team2.elearningapplication.dto.request.admin.category.UpdateCategoryRequest;
import team2.elearningapplication.dto.response.admin.category.AddCategoryResponse;
import team2.elearningapplication.dto.response.admin.category.DeleteCategoryResponse;
import team2.elearningapplication.dto.response.admin.category.FindAllCategoryResponse;
import team2.elearningapplication.dto.response.admin.category.UpdateCategoryResponse;
import team2.elearningapplication.entity.Category;
import team2.elearningapplication.repository.ICategoryRepository;
import team2.elearningapplication.service.ICategoryService;

import java.util.List;
import java.util.Objects;

import static com.mysql.cj.conf.PropertyKey.logger;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements ICategoryService {


    private final ICategoryRepository categoryRepository;
    @Override
    public ResponseCommon<AddCategoryResponse> addCategory(AddCategoryRequest addCategoryRequest) {
        try {
            Category category = categoryRepository.findCategoryByName(addCategoryRequest.getName()).orElse(null);
            // if category not null -> tell user
            if(!Objects.isNull(category)){
                return new ResponseCommon<>(ResponseCode.CATEGORY_EXIST,null);
            }
            // if category is null -> new category
            if(Objects.isNull(category)){
                category = new Category();
            }


            category.setName(addCategoryRequest.getName());
            // Save category to database
            Category savedCategory = categoryRepository.save(category);

            // If category is not saved successfully, return a FAIL response
            if (savedCategory == null) {
                return new ResponseCommon<>(ResponseCode.FAIL, null);
            }

            log.debug("Add category success");
            return new ResponseCommon<>(ResponseCode.SUCCESS,new AddCategoryResponse("Add category success"));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }


    @Override
    public ResponseCommon<UpdateCategoryResponse> updateCategory(UpdateCategoryRequest updateCategoryRequest) {
        try {
            Category category = categoryRepository.findCategoryById(updateCategoryRequest.getCategoryID()).orElse(null);
            // if category is null -> tell user
            if(Objects.isNull(category)) return new ResponseCommon<>(ResponseCode.CATEGORY_NOT_EXIST,null);
            else {
                Category categoryUpdate = category;
                categoryUpdate.setName(updateCategoryRequest.getCategoryUpdate());
                categoryRepository.save(categoryUpdate);
                return new ResponseCommon<>(ResponseCode.SUCCESS,new UpdateCategoryResponse("Update Category Success"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }

    @Override
    public ResponseCommon<DeleteCategoryResponse> deleteCategory(DeleteCategoryRequest deleteCategoryRequest) {
        try {
            Category category = categoryRepository.findCategoryById(deleteCategoryRequest.getCategoryID()).orElse(null);
            // if category is null -> tell user
            if(Objects.isNull(category)) return new ResponseCommon<>(ResponseCode.CATEGORY_NOT_EXIST,null);
            else {
                Category categoryUpdate = category;
                categoryUpdate.setDeleted(true);
                categoryRepository.save(categoryUpdate);
                return new ResponseCommon<>(ResponseCode.SUCCESS, new DeleteCategoryResponse("Delete Category Success"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }

    @Override
    public ResponseCommon<FindAllCategoryResponse> findAllCategory() {
        try {
            List<Category> listCategory = categoryRepository.findAll();
            // if list is empty -> tell user
            if(listCategory.isEmpty()){
                return new ResponseCommon<>(ResponseCode.CATEGORY_LIST_IS_EMPTY,null);
            } // else -> return list
            else {
                FindAllCategoryResponse response = new FindAllCategoryResponse("Get all success",listCategory);
                return new ResponseCommon<>(ResponseCode.SUCCESS,response);
            }
        } catch  (Exception e) {
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }
}
