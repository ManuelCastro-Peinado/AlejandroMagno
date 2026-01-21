package es.studium.alejandromagnoapp.ui.conquistas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ConquistaViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ConquistaViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }

    // Método para actualizar el texto desde el Fragment
    public void setText(String texto) {
        mText.setValue(texto);
    }
}
