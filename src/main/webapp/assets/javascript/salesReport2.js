$(document).ready(function() {
    $('#table_id').DataTable();
});

today();
function today() {

    var currentTime = new Date()
    var maxDate = new Date(currentTime.getFullYear(), currentTime
            .getMonth(), +currentTime.getDate() + 1); //max date current date
    console.log(maxDate);
    let date = JSON.stringify(maxDate)
    date = date.slice(1, 11)
    console.log(date)
    document.getElementById("maxDate").setAttribute("max", date);
    document.getElementById("startDate").setAttribute("max", date);
}