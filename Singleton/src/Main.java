import com.designpatterns.singleton.logger_v1.LoggerV1;
import com.designpatterns.singleton.logger_v2.LoggerV2;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // V1 Main
        LoggerV1 logger = new LoggerV1();
        LoggerV1 logger2 = new LoggerV1();
        LoggerV1 logger3 = new LoggerV1();

        logger.logMeesageSent("00011221", "Nope");
        logger2.logReceived("00011221", "Like this!");
        logger.logReceived("00112231", "Hello");
        logger3.logMeesageSent("0123456", "Bye!");
        logger2.logReceived("00011221", "Yessssss!");

        // V2 Main

        LoggerV2 log1 = LoggerV2.getInstance();
        LoggerV2 log2 = LoggerV2.getInstance();
        LoggerV2 log3 = LoggerV2.getInstance();

        log1.logMeesageSent("00011221", "Nope");
        log2.logReceived("00011221", "Like this!");
        log1.logReceived("00112231", "Hello");
        log3.logMeesageSent("0123456", "Bye!");
        log2.logReceived("00011221", "Yessssss!");
    }
}