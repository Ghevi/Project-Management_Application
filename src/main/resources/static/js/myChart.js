var chartDataStr = decodeHtml(chartData);
var chartJsonArray = JSON.parse(chartDataStr);

var arrayLength = chartJsonArray.length;
var numericData = [];
var labelData = [];

// populate the chart
for(var i = 0; i < arrayLength; i++){
    numericData[i] = chartJsonArray[i].value;
    labelData[i] = chartJsonArray[i].label;
}

// For a pie chart
new Chart(document.getElementById("myPieChart"), {
    type: 'pie',  // change to doughnut for a different chart

    // The data for our dataset
        data: {
            labels: labelData,
            datasets: [{
                label: 'My First dataset',
                backgroundColor: ["#3e95cd", "#8e5ea2", "#3cda9f"],
                data: numericData
            }]
        },

        // Configuration options go here (json object)
        options: {
            title: {
            display: true,
            text: 'Project Statuses'
            }
        }
});

// [{"label": "COMPLETED", "value": 1}, {"label": "INPROGRESS", "value": 2}, {"label": "NOTSTARTED", "value": 1}]
function decodeHtml(html){
    var txt = document.createElement("textarea");
    txt.innerHTML = html;
    return txt.value;
}