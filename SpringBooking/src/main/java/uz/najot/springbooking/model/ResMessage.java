package uz.najot.springbooking.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResMessage {
    private Integer code;
    private String message;
    private Object object;

    public static ResMessage getSuccess(int i, String success) {
        return new ResMessage(i,success,null);
    }
    public static ResMessage getSuccess(Object object) {
        return new ResMessage(0,"success",object);
    }
}
