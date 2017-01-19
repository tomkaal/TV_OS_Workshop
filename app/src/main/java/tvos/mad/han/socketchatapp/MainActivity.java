package tvos.mad.han.socketchatapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class MainActivity extends AppCompatActivity {

    //url ingeven

    public String name = "";
    public ListView listView;

    private Socket mSocket;

    private ArrayList<String> messages = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    private void showAlertDialogForName() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Name please:");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO: Verkrijg je naam uit de input.
                // TODO: Maak een JSON object (mvb door de onderstaande functies) en verstuur hem met een socket naar de server.

            }
        });

        builder.show();
    }

    private String getChatMessageFromJSONObject(JSONObject jsonObject){
        String message = "";
        try {
            message = jsonObject.getString("text");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return message;
    }

    private JSONObject getChatMessageJSONString(String name, String chatMessage){
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("text", name + ": " + chatMessage );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    private JSONObject getRegisterJSONString(String name){
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("name", name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    private void hideKeyboard(){
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
