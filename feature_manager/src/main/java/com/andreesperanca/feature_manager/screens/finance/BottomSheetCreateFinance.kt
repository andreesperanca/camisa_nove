package com.andreesperanca.feature_manager.screens.finance

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andreesperanca.ui_components.components.buttons.DefaultButton
import com.andreesperanca.ui_components.components.radio_button.RadioButtonDefault
import com.andreesperanca.ui_components.theme.CamisaNoveTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetCreateFinance(
    modifier: Modifier = Modifier,
    closeClick: () -> Unit)
{
    Column(
        modifier = modifier
            .verticalScroll(state = rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally)
    {

//        val focusRequester = remember { FocusRequester() }
        val radioOptions = listOf("Calls", "Missed", "Friends")
        var state by remember { mutableStateOf(true) }
        val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
        val focusRequest = remember { FocusRequester() }
        val focusManager = LocalFocusManager.current
        var showDatePickerDialog by remember {
            mutableStateOf(false)
        }
        val datePickerState = rememberDatePickerState()
        var selectedDate by remember {
            mutableStateOf("")
        }

        var titleValue by remember { mutableStateOf("") }
        var transitionValue by remember { mutableStateOf("") }

        CenterAlignedTopAppBar(
            title = {
                Text(
                    "Criar transação",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            navigationIcon = {
                IconButton(onClick = {
                    closeClick()
                }) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Localized description"
                    )
                }
            }
        )

        if (showDatePickerDialog) {
            DatePickerDialog(
                onDismissRequest = { showDatePickerDialog = false },
                confirmButton = {
                    Button(
                        onClick = {
                            datePickerState
                                .selectedDateMillis?.let { millis ->
                                    selectedDate = millis.toBrazilianDateFormat()
                                    focusManager.clearFocus()
                                }
                            showDatePickerDialog = false
                        }) {
                        Text(text = "Escolher data")
                    }
                }) {
                DatePicker(state = datePickerState)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                value = selectedDate,
                onValueChange = { },
                Modifier
                    .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                    .onFocusEvent {
                        if (it.isFocused) {
                            showDatePickerDialog = !showDatePickerDialog
                        }
                    }
                    .widthIn(80.dp)
                    .weight(0.5f),
                label = {
                    Text("Date")
                },
                readOnly = true,
                singleLine = true,
            )

            Spacer(modifier = Modifier.padding(8.dp))

            OutlinedTextField(
                modifier = Modifier
                    .padding(end = 16.dp, top = 8.dp, bottom = 8.dp)
                    .widthIn(80.dp)
                    .weight(0.5f),
                value = transitionValue,
                onValueChange = {
                    transitionValue = it
                },
                singleLine = true,
                label = { Text(text = "Value") },
                placeholder = { Text(text = "Enter with value") },
            )


        }
        Spacer(modifier = Modifier.padding(8.dp))
        RadioButtonDefault()

        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            value = titleValue,
            onValueChange = {
                titleValue = it
            },
            label = { Text(text = "Description transaction") },
            singleLine = true,
            placeholder = { Text(text = "Enter with title") },
        )
        
        DefaultButton(
            modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues = PaddingValues(16.dp)),
            onClickCta = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomSheetCreateFinancePreview() {
    CamisaNoveTheme() {
        BottomSheetCreateFinance(closeClick = {})
    }
}


fun Long.toBrazilianDateFormat(
    pattern: String = "dd/MM/yyyy"
): String {
    val date = Date(this)
    val formatter = SimpleDateFormat(
        pattern, Locale("pt-br")
    ).apply {
        timeZone = TimeZone.getTimeZone("GMT")
    }
    return formatter.format(date)
}