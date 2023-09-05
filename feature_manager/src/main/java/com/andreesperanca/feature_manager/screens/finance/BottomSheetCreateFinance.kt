package com.andreesperanca.feature_manager.screens.finance

import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andreesperanca.ui_components.components.buttons.DefaultButton
import com.andreesperanca.ui_components.components.texts.TitleMedium
import com.andreesperanca.ui_components.theme.CamisaNoveTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetCreateFinance(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .verticalScroll(state = rememberScrollState())
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    )
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
        var descriptionValue by remember { mutableStateOf("") }
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
                    showDatePickerDialog = !showDatePickerDialog
                }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
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
                    .padding(horizontal = 16.dp, vertical = 8.dp)
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

            OutlinedTextField(
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 16.dp)
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

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectableGroup(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Despesa")
                RadioButton(
                    selected = state,
                    onClick = { state = true },
                    modifier = Modifier.semantics { contentDescription = "Localized Description" }
                )
                Text(text = "Receita")
                RadioButton(
                    selected = !state,
                    onClick = { state = false },
                    modifier = Modifier.semantics { contentDescription = "Localized Description" }
                )
            }
        }

        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            value = titleValue,
            onValueChange = {
                titleValue = it
            },
            label = { Text(text = "Title") },
            singleLine = true,
            placeholder = { Text(text = "Enter with title") },
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = descriptionValue,
            onValueChange = {
                descriptionValue = it
            },
            singleLine = true,
            label = { Text(text = "Subtitle") },
            placeholder = { Text(text = "Enter with subtitle") },
        )

        DefaultButton(modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues = PaddingValues(16.dp))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomSheetCreateFinancePreview() {
    CamisaNoveTheme() {
        BottomSheetCreateFinance()
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