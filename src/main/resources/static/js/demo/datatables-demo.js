// Call the dataTables jQuery plugin
$(document).ready(function () {

  $.getJSON('/userinfo.json', function (data1) {
    $('#dataTable').DataTable({
      data: data1,
      columns: [
        {data: "name"},
        {data: "position"},
        {data: "office"},
        {data: "age"},
        {data: "startDate"},
        {data: "salary"}
      ]
    });
  });
});
