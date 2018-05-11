package exception;

/**
 * @author terry
 * @date 18-5-11
 */
public class BeansUndefinedException extends BeansException {

    private static final long serialVersionUID = 8887279271512404724L;

    public BeansUndefinedException() {
        super("Beans未定义");
    }
}
