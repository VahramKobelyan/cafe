var $TABLE = $('#table');
var $BTN = $('#export-btn');
var $EXPORT = $('#export');

$('.table-add').click(function () {
    var $clone = $TABLE.find('tr.hide').clone(true).removeClass('hide table-line');
    $TABLE.find('table').append($clone);
});

$('.table-remove').click(function () {
    $(this).parents('tr').detach();
});

$('.table-up').click(function () {
    var $row = $(this).parents('tr');
    if ($row.index() === 1) return; // Don't go above the header
    $row.prev().before($row.get(0));
});

$('.table-down').click(function () {
    var $row = $(this).parents('tr');
    $row.next().after($row.get(0));
});

// A few jQuery helpers for exporting only
jQuery.fn.pop = [].pop;
jQuery.fn.shift = [].shift;

$BTN.click(function () {
    var $rows = $TABLE.find('tr:not(:hidden)');
    var headers = [];
    var data = [];

    // Get the headers (add special header logic here)
    $($rows.shift()).find('th:not(:empty)').each(function () {
        headers.push($(this).text());
    });

    // // Turn all existing rows into a loopable array
    $rows.each(function () {
        var $td = $(this).find('td');
        var h = {};
    //
    //     // Use the headers from earlier to name our hash keys
        headers.forEach(function (header, i) {
            h[header] = $td.eq(i).text();
        });
    //
        data.push(h);
    });

    // Output the result

    $EXPORT.text(JSON.stringify(data));
});

// $(document).ready(function(){
//     id_numbers = new Array();
//     $.ajax({
//         url:"/product/all",
//         type:"GET",
//         success:function(msg){
//             id_numbers = msg;
//             $.each(id_numbers, function(id, id_number) {
//                 $('.product')
//                     .append($("<option></option>")
//                         .attr("value",id_number['id'])
//                         .text(id_number['name']));
//             });
//         },
//         dataType:"json"
//     });
//
// });

// $(function() {
//     $('.product').on('change', function() {
//         var result = id_numbers.filter(obj => {
//             return obj.id === $( this ).val()
//         })
//         $('#yourDiscount').text($(this).val());
//     }
//     $('.product'.change(function() {
//         $('#ancestor').val($(this).val());
//
//     }).change(); // Trigger the event
// });