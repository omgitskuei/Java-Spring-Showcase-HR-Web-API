<script>
//objects
  function DropdownOption(selected, value, label) {
    this.selected = selected;
    this.value = value;
    this.label = label;
  }

  function DropdownSelect(disabled, dropdownList) {
    this.disabled = disabled;
    this.dropdownList = dropdownList;
  }
  
  "use strict";
  //global variables
  var deptNoSelectedValue = "";
  var secNoSelectedValue = "";
  var empNoSelectedValue = "";
  var prjNoSelectedValue = "";
  var hideRetiredEmp = true;
  var oprStartDateValue = "";
  var oprEndDateValue = "";
  var empNoAllOptionsBackup = [];
  

  $("#deptNo").change(function(e) {
    var thisVal = $(this).val();
    var thisLabel = $('#deptNo option:selected').attr('label');
    console.log("deptNoChangeHandler start: " + "selected Option{value = " + thisVal + ", label = " + thisLabel + "}");
    // Set global variable
    deptNoSelectedValue = thisVal;
    var deptNoSelected = {
      "optionLabel": thisLabel,
      "optionValue": thisVal,
      "selected": "selected"
    };
    $.ajax({
      method: 'POST',
      url: 'document.URL/../InitDataSecNo',
      contentType: 'application/json ; charset=UTF-8',
      accept: 'application/json',
      dataType: 'JSON',
      async: 'true',
      data: JSON.stringify(deptNoSelected)
    }).done(function(response, success, xhr) {
      var returnedDropdownListArray = xhr.responseJSON.dropdownList;
      // Enable the next Select
      $('#secNo').prop('disabled', false);
      // Clear Select of previous Options
      removeOptions('secNo');
      removeOptions('empNo');
      // Add returned Options to Select
      for (var i = 0; i < returnedDropdownListArray.length; i++) {
        var newOptionAdded = createNewOption(returnedDropdownListArray[i].optionValue, returnedDropdownListArray[i].optionLabel, 'secNo');
      }
    }).fail(function(response, success, xhr) {
      console.log("xhr.getAllResponseHeaders: " + xhr.getAllResponseHeaders());
      console.log("xhr.status: " + xhr.status + ", xhr.statusText: " + success);
    });
  })

  $("#secNo").change(function(e) {
    // Get deptNo Option
    var deptNoVal = $("#deptNo").val();
    var deptNoLabel = $('#deptNo option:selected').attr('label');
    // Get secNo Option
    var thisVal = $(this).val();
    var thisLabel = $('#secNo option:selected').attr('label');
    console.log("secNoChangeHandler start: selected's value = [" + thisVal + "], label = [" + thisLabel + "]");
    // Set global variable
    secNoSelectedValue = thisVal;
    var selected = [{
        "optionLabel": deptNoLabel,
        "optionValue": deptNoVal,
        "selected": "selected"
      },
      {
        "optionLabel": thisLabel,
        "optionValue": thisVal,
        "selected": "selected"
      }
    ];
    $.ajax({
      method: 'POST',
      url: 'document.URL/../InitDataEmpNo',
      contentType: 'application/json ; charset=UTF-8',
      accept: 'application/json',
      dataType: 'JSON',
      async: 'true',
      data: JSON.stringify(selected)
    }).done(function(response, success, xhr) {
      var returnedDropdownListArray = xhr.responseJSON.dropdownList;
      // Enable the next Select
      $('#empNo').prop('disabled', false);
      // Clear Select of previous Options
      removeOptions('empNo');
      // Add returned Options to Select
      for (var i = 0; i < returnedDropdownListArray.length; i++) {
        var newOptionAdded = createNewOption(returnedDropdownListArray[i].optionValue, returnedDropdownListArray[i].optionLabel, 'empNo');
        empNoAllOptionsBackup[i] = newOptionAdded;
      }
      // Enable "Hide Retired Emp" checkbox (for user to uncheck if they want to unhide)
      $('#retiredEmp').prop('disabled', false);
    }).fail(function(response, success, xhr) {
      console.log("xhr.getAllResponseHeaders: " + xhr.getAllResponseHeaders());
      console.log("xhr.status: " + xhr.status + ", xhr.statusText: " + success);
    });
  })

  $("#empNo").change(function(e) {
    // Get empNo Option
    var thisVal = $(this).val();
    var thisLabel = $('#empNo option:selected').attr('label');
    console.log("empNoChangeHandler start: selected's value = [" + thisVal + "], label = [" + thisLabel + "]");
    // Set global variable
    empNoSelectedValue = thisVal;
  })
  // returns true/false if this attribute is present for element
  $.fn.hasAttr = function(name) {
    return this.attr(name) !== undefined;
  };

  $("#retiredEmp").click(function() {
    // Get empNo Option
    // Unchecking the checkbox - Unhide
    if ($('#retiredEmp').hasAttr('checked')) {
      $('#retiredEmp').removeAttr('checked');
      console.log("retiredEmpChangeHandler start: new checked property (true/false)  = [false]");
      $("#retiredEmp option").each(function() {
        $(this).removeAttr('hidden');
      });
    }
    // Checking the checkbox - Hide
    else {
      $('#retiredEmp').attr('checked','checked');
      console.log("retiredEmpChangeHandler start: new checked property (true/false)  = [true]");
      $("#retiredEmp option").each(function() {
        var label = $(this).attr('label');
        if (label.substring(label.length-3, label.length-1) == "離職") {
        	$(this).attr('hidden');
        };
      });

    }
  })

  // Add new option to a Select
  var createNewOption = function(value, label, targetSelect) {
    var selectedOption = '';
    var firstNonHiddenOption = new Boolean(false);

    // Hide Options with EMPSTAT=1
    if (label.substring(label.length - 3, label.length - 1) == "離職") {
      selectedOption = '<option value=' + value + ' label=' + label + ' hidden></option>';
    } else {
      // Make it so that Hidden Options do NOT get selected (by default automatically)
      if (firstNonHiddenOption == false) {
        selectedOption = '<option value=' + value + ' label=' + label + ' selected ></option>';
        firstNonHiddenOption = true;
      } else {
        selectedOption = '<option value=' + value + ' label=' + label + ' ></option>';
      }
    }
    $('#' + targetSelect).append(selectedOption);
    return selectedOption;
  }
  // Remove all options from a select
  var removeOptions = function(selectId) {
    var selectElement = document.getElementById(selectId);
    var i, L = selectElement.options.length - 1;
    for (i = L; i >= 0; i--) {
      selectElement.remove(i);
    }
  }
  // Convert param day Gregorian year to MingGuo year
  var calcDayInMG = function(date) {
    var year = (date.getFullYear() - 1911).toString();
    var month = date.getMonth() + 1;
    if (month < 10) {
      month = "0" + (month.toString());
    } else {
      month = month.toString();
    }
    var day = date.getDate();
    if (day < 10) {
      day = "0" + (day.toString());
    } else {
      day = day.toString();
    }
    var thisYearInMG = year + month + day;
    return thisYearInMG;
  }
  //Calculate default value for oprStart/EndDt (This week Monday and Sunday in MG)
  var calcThisWeekMondayInMG = function() {
    var curr = new Date;
    var monday = new Date(curr.setDate(curr.getDate() - curr.getDay() + 1));
    var friday = new Date(curr.setDate(curr.getDate() - curr.getDay() + 7));
    monday = calcDayInMG(monday);
    friday = calcDayInMG(friday);
    document.getElementById("oprStartDt").defaultValue = monday;
    document.getElementById("oprEndDt").defaultValue = friday;
  }
  //Restricts input for each element in the set of matched elements to the given inputFilter.
  (function($) {
    $.fn.inputFilter = function(inputFilter) {
      return this.on("input contextmenu drop", function() {
        if (inputFilter(this.value)) {
          this.oldValue = this.value;
          this.oldSelectionStart = this.selectionStart;
          this.oldSelectionEnd = this.selectionEnd;
        } else if (this.hasOwnProperty("oldValue")) {
          this.value = this.oldValue;
          this.setSelectionRange(this.oldSelectionStart, this.oldSelectionEnd);
        } else {
          this.value = "";
        }
      });
    };
  }(jQuery));
  //Set a filter allowing only numbers 0 to this year in MingGuo Calendar
  $("#oprStartDt").inputFilter(function(value) {
    var today = new Date();
    var thisYearInMG = calcDayInMG(today);
    console.log("thisYearInMG = " + parseInt(thisYearInMG));
    return /^\d*$/.test(value) && (value === "" || parseInt(value) <= thisYearInMG);
  });

  $("#oprEndDt").inputFilter(function(value) {
    var today = new Date();
    var thisYearInMG = calcDayInMG(today);
    console.log("thisYearInMG = " + parseInt(thisYearInMG));
    return /^\d*$/.test(value) && (value === "" || parseInt(value) <= thisYearInMG);
  });
  // oprStart/EndDt change handler
  function oprStartDtChangeHandler(e) {
    console.log("oprStartDtChangeHandler start");
    var val = e.target.value;
    console.log(val);
    oprStartDateValue = val;
  }

  function oprEndDtChangeHandler(e) {
    console.log("oprEndDtChangeHandler start");
    var val = e.target.value;
    console.log(val);
    oprEndDateValue = val;
  }


  $(document).ready(function() {
    console.log("current url=" + window.location);
    // Set default values for oprStartDt and oprEndDt
    calcThisWeekMondayInMG;

    $('#retiredEmp').prop('disabled', true); //TODO
  });
</script>
