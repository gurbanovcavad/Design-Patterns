package org.example.creational;
import java.util.Scanner;

interface Button {
    void click();
}

interface CheckBox {
    void check();
}

class WindowsButton implements Button {

    @Override
    public void click() {
        System.out.println("Windows button clicked");
    }

    @Override
    public String toString() {
        return "Windows Button";
    }
}

class WindowsCheckBox implements CheckBox {

    @Override
    public void check() {
        System.out.println("Windows checkbox checked");
    }

    @Override
    public String toString() {
        return "Windows CheckBox";
    }
}

class MacButton implements Button {

    @Override
    public void click() {
        System.out.println("Mac button clicked");
    }

    @Override
    public String toString() {
        return "Mac Button";
    }
}

class MacCheckBox implements CheckBox {

    @Override
    public void check() {
        System.out.println("Mac checkbox checked");
    }

    @Override
    public String toString() {
        return "Mac CheckBox";
    }
}

interface GUIFactory {
    Button createButton();
    CheckBox createCheckBox();
}

class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}

class MacFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}

public class AbstractFactory {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Choose platform windows/mac: ");
        String platform = scan.nextLine().toLowerCase();

        GUIFactory factory = switch (platform) {
            case "windows":
                yield new WindowsFactory();
            case "mac":
                yield new MacFactory();
            default:
                throw new IllegalArgumentException("Unsupported platform");
        };

        Button button = factory.createButton();
        CheckBox checkBox = factory.createCheckBox();

        System.out.println(button);
        System.out.println(checkBox);

        button.click();
        checkBox.check();

        scan.close();
    }
}