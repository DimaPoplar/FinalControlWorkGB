package ReestrPets;

import ReestrPets.Controll.WorkAnimal;
import ReestrPets.Storage.CreateAnnimal;
import ReestrPets.View.ConsoleView;
import ReestrPets.View.InterView;
import ReestrPets.View.InterView.*;

public class AppReestr {
    public static void run() {
        WorkAnimal kennelAccounting = new WorkAnimal(new CreateAnnimal());
        InterView view = new ConsoleView(kennelAccounting);

        while (true) {
            view.showKennelRegistry();
            MainMenuCommand code = view.showMainMenuWithResult();
            switch (code) {
                case ADD_ANIMAL -> {
                    boolean result = view.showAddAnimalDialog();
                    String resMessage = result ? "Животное добавлено" : "Не удалось добавить животное";
                    System.out.println(resMessage);
                }
                case SHOW_SKILLS -> {
                    view.showDetailInfoAnimalDialog();
                }
                case REMOVE_ANIMAL -> {
                    int removeId = view.showRemoveAnimalDialog();
                    String resMessage = removeId > -1  ? "Животное удалено" + removeId : "Не удалось  удалить животное";
                    System.out.println(resMessage);
                }
                case EXIT -> {
                    System.out.println("exit");
                    return;
                }
            }
        }
    }
}
