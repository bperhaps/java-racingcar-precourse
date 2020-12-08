package racingcar.domains.input;

import racingcar.domains.error.RacingCarGameException;
import racingcar.domains.validate.Validator;
import racingcar.domains.validate.Validators;

import java.util.Scanner;

public class AttemptNumberInput implements Input<Integer> {

    private static final String INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    private Scanner scanner;
    private String attemptNumber;

    public AttemptNumberInput(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Integer get() throws RacingCarGameException {
        printInputMessage();
        inputFromUser();
        isValid();

        return Integer.parseInt(attemptNumber);
    }

    private void printInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }

    private void inputFromUser() {
        attemptNumber = scanner.nextLine();
    }

    private void isValid() throws RacingCarGameException {
        Validator validator = Validators.getAttemptNumberInputValidator();
        validator.isValid(attemptNumber);
    }
}
