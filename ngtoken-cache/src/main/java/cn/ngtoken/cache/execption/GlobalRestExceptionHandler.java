package cn.ngtoken.cache.execption;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * https://cloud.tencent.com/developer/article/1059786
 * https://www.baeldung.com/exception-handling-for-rest-with-spring
 * https://stackoverflow.com/questions/6478508/whats-the-difference-between-a-handler-a-resolver-and-an-interceptor-in-spring
 * https://docs.spring.io/spring/docs/3.0.x/reference/mvc.html
 *
 * Interceptor:
 *
 * Spring's handler mapping mechanism has the notion of handler interceptors,
 * that can be extremely useful when you want to apply specific functionality to certain requests,
 * for example, checking for a principal. Interceptors located in the handler mapping must implement HandlerInterceptor from the org.springframework.web.servlet package.
 * This interface defines three methods, one that will be called before the actual handler will be executed,
 * one that will be called after the handler is executed, and one that is called after the complete request has finished.
 * These three methods should provide enough flexibility to do all kinds of pre- and post-processing.
 *
 * Handler:
 *
 * a DispatcherServlet that dispatches requests to handlers, with configurable handler mappings,
 * view resolution, locale and theme resolution as well as support for uploading files.
 * The default handler is based on the @Controller and @RequestMapping annotations,
 * offering a wide range of flexible handling methods.
 *
 * Resolver(s):
 *
 * View resolvers: View resolvers are components capable of resolving view names to views
 * Locale resolver: A locale resolver is a component capable of resolving the locale a client is using,
 * in order to be able to offer internationalized views
 * Theme resolver: A theme resolver is capable of resolving themes your web application can use,
 * for example, to offer personalized layouts
 * Multipart file resolver: A multipart file resolver offers the functionality to process file uploads from HTML forms
 * Handler exception resolver(s): Handler exception resolvers offer functionality to map exceptions to views or implement other more complex exception handling code
 * @author heidsoft
 */
@ControllerAdvice
//@RestController
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public void defaultExceptionHandler() {
        System.out.println("defaultExceptionHandler .....");
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public final ResponseEntity<ApiErrorResponse> handleUserNotFoundException(StudentNotFoundException ex, WebRequest request) {
        ApiErrorResponse apiErrorResponse = ApiErrorResponse.ApiErrorResponseBuilder.anApiErrorResponse()
                .withError_code("100")
                .withDetail(request.getDescription(false))
                .withMessage(ex.getMessage())
                .withStatus(HttpStatus.BAD_REQUEST)
                .build();
        System.out.println("handleUserNotFoundException .....");
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        ApiErrorResponse response =new ApiErrorResponse.ApiErrorResponseBuilder()
                .withStatus(status)
                .withError_code(HttpStatus.BAD_REQUEST.name())
                .withMessage(ex.getLocalizedMessage()).build();

        return new ResponseEntity<>(response, response.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Malformed JSON request ";
        ApiErrorResponse response =new ApiErrorResponse.ApiErrorResponseBuilder()
                .withStatus(status) .withError_code("BAD_DATA")
                .withMessage(ex.getLocalizedMessage())
                .withDetail(error+ex.getMessage()) .build();
        return new ResponseEntity<>(response, response.getStatus());
    }
}