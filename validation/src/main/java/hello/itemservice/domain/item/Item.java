package hello.itemservice.domain.item;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

import java.util.List;

@Data
//@ScriptAssert(lang = "javascript", script = "_this.price * _this.quantity >= 100000"
//        , message = "상품의 가격 * 수량의 합은 100,000 원 이상이여야 합니다.")
// @ScriptAssert 오브젝트 검증 기능이 너무 약함 권장하지 않음
public class Item {

//    @NotNull(groups = UpdateCheck.class)    //수정 요구사항 추가
    private Long id;

//    @NotBlank(groups = {SaveCheck.class, UpdateCheck.class})
    private String itemName;

//    @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
//    @Range(min = 1000, max = 1000000, groups = {SaveCheck.class, UpdateCheck.class})
    private Integer price;

//    @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
//    @Range(max = 9999,groups = SaveCheck.class)
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
