<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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


<h4 class="text-center" style="margin-top: 1rem;">Farmer Registration Using Unique ID</h4>

<form action="/searchFarmer" method="post" modeAttribute="farmer" id="farmerRegistrationForm">

    <div class="row" style="margin: 3rem;">
        <div class="col-md-3">
            <label for="uniqueId" class="form-label">Unique ID</label>
            <select class="form-select" aria-label="Default select example" style="background-color: aliceblue" id="uniqueId" name="uniqueId">
                <option value="Select" selected><--Select--></option>
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

        <div class="col-md-3" style="margin-top: 2rem;">
            <button type="button" onclick="submitFarmerForm()" class="btn btn-success">Search</button>
            <button type="button" onclick="reloadPage()" class="btn btn-warning">Reset</button>
        </div>
    </div>

</form>


<c:choose>
    <c:when test="${data == 'Data'}">
        <div class="row" style="margin: 3rem;">
            <table id="dynamicTable" border = "1" align="center" class="table table-striped table-bordered" cellspacing="0">
                <thead>
                <tr>
                    <td><input type="checkbox"></td>
                    <th>Name</th>
                    <th>Father's Name</th>
                    <th>Age</th>
                    <th>Gender</th>
                    <th>Relation</th>
                    <th>Bank Name</th>
                    <th>IFSC Code</th>
                    <th>Account Number</th>
                    <th>Mobile Number</th>
                </tr>
                </thead>

                <tbody style="background-color: aliceblue">
                <tr style="background-color: aliceblue">
                    <td ><input type="checkbox"></td>
                    <td>${farmer.name}</td>
                    <td>${farmer.fathersName}</td>
                    <td>${farmer.age}</td>
                    <td>${farmer.gender}</td>
                    <td>${farmer.relation}</td>
                    <td>${farmer.bank.bankName}</td>
                    <td>${farmer.bank.ifscCode}</td>
                    <td>${farmer.bank.accountNumber}</td>
                    <td>${farmer.mobile}</td>
                </tr>
                </tbody>


                <tfoot>
                <tr>
                    <td colspan="10" style="text-align: center;">
                        <button class="btn btn-info" onclick="window.location.href='${pageContext.request.contextPath}/selectFamilyMember'">Select Family Member</button>
                    </td>
                </tr>
                </tfoot>

            </table>
        </div>
    </c:when>


<%--    <c:when test="${flashMessage == 'Failed'}">--%>
<%--        <script>swal("Failed", "Failed To Add Drive!", "error")</script>--%>
<%--    </c:when>--%>
<%--        <c:otherwise>--%>
<%--            <p>No Data!</p>--%>
<%--        </c:otherwise>--%>
</c:choose>



<script>

    $(document).ready(function (){
        $('#id1').hide();
        $('#id2').hide();
        $('#id3').hide();
        // $('#dynamicTable').hide();
    });

    jQuery(function($) {
        $('#dynamicTable').DataTable({
            pageLength: 10,
            paging: true,
            searching: true,
            order: [[0, "asc"]],
            columnDefs: [{ orderable: true, targets: [3] }]
        });
    })

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
        else if (this.value == "Select"){
            $('#id1').hide();
            $('#id2').hide();
            $('#id3').hide();
        }
    });

    function submitFarmerForm(){
        $('#farmerRegistrationForm').submit();
        $('#dynamicTable').show();
    }

    function reloadPage(){
        window.location.reload();
    }
</script>
</body>
</html>

