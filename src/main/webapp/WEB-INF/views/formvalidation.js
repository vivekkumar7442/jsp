$("feedbackUp").validate({
    // Specify validation rules
    rules: {
      // The key name on the left side is the name attribute
      // of an input field. Validation rules are defined
      // on the right side
      firstname: "required",
    
      
    },
    // Specify validation error messages
    messages: {
      firstname: "Please enter your firstname",
  
    }
  });


