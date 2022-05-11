<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--    Bootstrap for Design--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <%--    For Validation--%>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css"/>
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"> </script>
    <title>Farmer Registration</title>
</head>
<body style="background-color: aliceblue">


<h4 class="text-center" style="margin-top: 1rem;">Farmer Registration</h4>

<form action="/saveFarmer" method="post" modeAttribute="farmer" id="farmerRegistrationForm">
    <div class="row" style="margin: 3rem;" >
        <div class="col-md-3">
            <label for="name" class="form-label">Farmer Name</label>
            <input type="text" class="form-control" id="name" name="name" style="background-color: aliceblue" placeholder="Enter Farmer's Name" required>
        </div>
        <div class="col-md-3">
            <label for="fathersName" class="form-label">Father's Name</label>
            <input type="text" class="form-control" id="fathersName" name="fathersName" style="background-color: aliceblue" placeholder="Enter Father's Name" required>
        </div>
        <div class="col-md-3">
            <label for="age" class="form-label">Age</label>
            <input type="number" class="form-control" id="age" name="age" style="background-color: aliceblue" placeholder="Enter Age" required>
        </div>
        <div class="col-md-3">
            <label class="form-label">Gender</label>
            <div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" id="male" style="background-color: aliceblue" name="gender" value="male">
                    <label class="form-check-label" for="male">Male</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" id="female" style="background-color: aliceblue" name="gender" value="female">
                    <label class="form-check-label" for="female">Female</label>
                </div>
            </div>
        </div>
    </div>

    <div class="row" style="margin: 3rem;">
        <div class="col-md-3">
            <label for="relation" class="form-label">Relation</label>
            <select class="form-select" aria-label="Default select example" style="background-color: aliceblue" id="relation" name="relation">
                <option selected><--Select--></option>
                <option value="Husband">Husband</option>
                <option value="Wife">Wife</option>
                <option value="Brother">Brother</option>
                <option value="Sister">Sister</option>
                <option value="Father">Father</option>
                <option value="Mother">Mother</option>
            </select>
        </div>
        <div class="col-md-3">
            <label for="bankName" class="form-label">Bank Name</label>
            <select class="form-select" aria-label="Default select example" style="background-color: aliceblue" id="bankName" name="bankName">
                <option selected><--Select--></option>
                <option value="State Bank of India">State Bank of India</option>
                <option value="Bank of Baroda">Bank of Baroda</option>
                <option value="Axis Bank">Axis Bank</option>
                <option value="Uco Bank">Uco Bank</option>
                <option value="HDFC Bank">HDFC Bank</option>
            </select>
        </div>
        <div class="col-md-3">
            <label for="ifscCode" class="form-label">IFSC Code</label>
            <input type="text" class="form-control" id="ifscCode" style="background-color: aliceblue" name="ifscCode" placeholder="Enter IFSC Code" required>
        </div>
        <div class="col-md-3">
            <label for="accountNumber" class="form-label">Account Number</label>
            <input type="text" class="form-control" id="accountNumber" style="background-color: aliceblue" name="accountNumber" placeholder="Enter  Account Number" required>
        </div>
    </div>

    <div class="row" style="margin: 3rem;">
        <div class="col-md-3">
            <label for="mobile" class="form-label">Mobile Number</label>
            <input type="text" class="form-control" id="mobile" style="background-color: aliceblue" name="mobile" placeholder="Enter Mobile Number" required>
        </div>
        <div class="col-md-3">
            <label for="uniqueId" class="form-label">Unique ID</label>
            <select class="form-select" aria-label="Default select example" style="background-color: aliceblue" id="uniqueId" name="uniqueId">
                <option selected><--Select--></option>
                <option value="Ack Id">Ack Id</option>
                <option value="Janadhaar Id">Janadhaar Id</option>
                <option value="Adhaar Id">Adhaar Id</option>
            </select>
        </div>
        <div class="col-md-3" id="id1">
            <label for="ackId" class="form-label">Acknowledge ID</label>
            <input type="text" class="form-control" id="ackId" style="background-color: aliceblue" name="ackId" placeholder="Enter Acknowledge ID" required>
        </div>
        <div class="col-md-3" id="id2">
            <label for="janadhaarId" class="form-label">Janadhaar ID</label>
            <input type="text" class="form-control" id="janadhaarId" style="background-color: aliceblue" name="janadhaarId" placeholder="Enter Janadhaar ID" required>
        </div>
        <div class="col-md-3" id="id3">
            <label for="adhaarId" class="form-label">Adhaar ID</label>
            <input type="text" class="form-control" id="adhaarId" style="background-color: aliceblue" name="adhaarId" placeholder="Enter Adhaar ID" required>
        </div>
    </div>

    <div class="row" style="margin: 3rem;">
        <div class="col-md-3">
            <button type="button" onclick="submitFarmerForm()" class="btn btn-success">Submit</button>
            <button type="reset" class="btn btn-warning">Reset</button>
        </div>
    </div>
</form>

<script>
    $(document).ready(function (){
        $('#id1').hide();
        $('#id2').hide();
        $('#id3').hide();
    });

    $( "#uniqueId" ).change(function() {
        if (this.value == "Ack Id"){
            $('#id1').show();
            $('#id2').hide();
            $('#id3').hide();
        }
        else if (this.value == "Janadhaar Id"){
            $('#id1').hide();
            $('#id2').show();
            $('#id3').hide();
        }
        else if (this.value == "Adhaar Id"){
            $('#id1').hide();
            $('#id2').hide();
            $('#id3').show();
        }
    });

    function submitFarmerForm(){
        $('#farmerRegistrationForm').submit();
    }
</script>
</body>
</html>
