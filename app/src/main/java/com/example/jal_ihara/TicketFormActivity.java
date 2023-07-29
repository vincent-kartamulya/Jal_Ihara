package com.example.jal_ihara;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TicketFormActivity extends AppCompatActivity {
    EditText editName, editQty;
    TextView validationError;
    Button buyButton;
    RadioGroup radioGroup;
    RadioButton vipRadio, regulerRadio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_form);

        editName = findViewById(R.id.editName);
        editQty = findViewById(R.id.editQty);
        validationError = findViewById(R.id.validationError);
        buyButton = findViewById(R.id.buyButton);
        vipRadio = findViewById(R.id.vipRadio);
        regulerRadio = findViewById(R.id.regulerRadio);
        radioGroup = findViewById(R.id.radioGroup);

        buyButton.setOnClickListener(v -> {
            // Get the text from the EditText fields
            String name = editName.getText().toString().trim();
            String qty = editQty.getText().toString().trim();
            int quantity = -1; // Default value to indicate invalid input

            // Perform validation
            boolean isNameEmpty = name.isEmpty();
            boolean isQtyEmpty = qty.isEmpty();
            int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();

            // Perform validation for the radio button selection
            boolean isRadioButtonSelected = selectedRadioButtonId != View.NO_ID;

            // Show/hide the validation error based on the validation result
            if (!isRadioButtonSelected || isNameEmpty || isQtyEmpty) {
                // At least one of the fields is empty, show the validation error

                if (isNameEmpty) {
                    validationError.setText("Name cannot be empty.");
                } else if (isQtyEmpty) {
                    validationError.setText("Quantity cannot be empty.");
                } else {
                    validationError.setText("Please select a ticket type.");
                }
                validationError.setVisibility(View.VISIBLE);
            } else {
                // Both fields have valid input, hide the validation error
                validationError.setVisibility(View.GONE);

                // Parse quantity to integer (handle potential NumberFormatException)
                try {
                    quantity = Integer.parseInt(qty);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    // Handle the invalid input, e.g., show an error message to the user
                    validationError.setText("Invalid quantity input.");
                    validationError.setVisibility(View.VISIBLE);
                    return;
                }

                if (quantity == 0) {
                    // Show an error for a non-positive quantity
                    validationError.setText("Quantity can't be 0");
                    validationError.setVisibility(View.VISIBLE);
                } else {
                    // Quantity is valid, proceed with other actions
                    validationError.setVisibility(View.GONE);

                    Intent intent = new Intent(TicketFormActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}