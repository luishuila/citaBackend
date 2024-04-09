package com.barberia.citaShow.config.Errores;

import com.barberia.citaShow.util.MessagesConstants;
import com.barberia.citaShow.util.ResponseMessage;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;




/*@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class DefaultControllerException  extends ResponseEntityExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(DefaultControllerException.class);

    @ExceptionHandler(value
            = { ApplicationCustomException.class})
    protected ResponseEntity<Object> handleAppException(  ApplicationCustomException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getResponse(), new HttpHeaders(), HttpStatus.OK, request);
    }


}*/
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@RestControllerAdvice
public class DefaultControllerException  extends ResponseEntityExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(DefaultControllerException.class);


   /* @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleAllExceptions(Exception ex) {
        // Personaliza la respuesta de acuerdo a la excepción
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
*/
   /* @ExceptionHandler(ApplicationCustomException.class)
    protected ResponseEntity<Object> handleCustomException(ApplicationCustomException ex) {
        // Personaliza la respuesta de acuerdo a la excepción
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }*/


   /* @ExceptionHandler(value = {RuntimeException.class})
    public  ResponseEntity<Object> runtimeExceptionHandedlr (ApplicationCustomException ex, WebRequest request){
        System.out.println(ex);
        ResponseMessage responseMessage = ResponseMessage.builder().code(13).message(ex.getMessage()).build();
        return  handleExceptionInternal(ex, ex.getResponse(), new HttpHeaders(), HttpStatus.OK,request);
    }*/
   @ExceptionHandler(value = {RuntimeException.class})
   public  ResponseEntity<ResponseMessage> runtimeExceptionHandedlr (RuntimeException exception){
       System.out.println(exception.getMessage());
       ResponseMessage responseMessage = ResponseMessage.builder().code(13).message(exception.getMessage()).build();
        return new ResponseEntity<>(responseMessage,HttpStatus.BAD_REQUEST );
    }
  /* @ExceptionHandler(value = {RuntimeException.class})
   public  ResponseEntity<ResponseMessage> runtimeExceptionHandedlr (ApplicationCustomException ex, WebRequest request){
       ResponseMessage responseMessage = ResponseMessage.builder().code(13).message(ex.getMessage()).build();
       return new ResponseEntity<>(responseMessage,HttpStatus.BAD_REQUEST );
   }
*/


        /*@ExceptionHandler(value
                = { ApplicationCustomException.class})
        protected ResponseEntity<Object> handleAppException(  ApplicationCustomException ex, WebRequest request) {
            return handleExceptionInternal(ex, ex.getResponse(), new HttpHeaders(), HttpStatus.OK, request);
        }*/




}
