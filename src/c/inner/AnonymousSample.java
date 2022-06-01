package c.inner;

public class AnonymousSample {
    public static void main(String[] args) {
        AnonymousSample sample = new AnonymousSample();
        sample.setButtonListener();
    }

    public void setButtonListener() {
        MagicButton button = new MagicButton();
        MagicButtonListener listener = new MagicButtonListener();
        button.setListener(listener);
        button.onClickProcess();
    }

    public void setButtonListenerAnonymous() {
        MagicButton button = new MagicButton();
        //이런식으로 선언도 됨
        EventListener listener = new EventListener() {
            @Override
            public void onClick() {
                System.out.println("Magic Button Clicked !!!");
            }
        };
        //이게 익명클래스였구나..?
        button.setListener(new EventListener() {
            @Override
            public void onClick() {
                System.out.println("Magic Button Clicked !!!");
            }
        });


        button.onClickProcess();
    }
}
