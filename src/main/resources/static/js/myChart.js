const chartDataStr = decodeHtml(chartData);
const chartJSONArray = JSON.parse(chartDataStr);

const arrayLength = chartJSONArray.length;
const numericData = chartJSONArray.map(element => element.value);
const labelData = chartJSONArray.map(element => element.label);

// For a pie chart
let myPieChart = new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f"],
            data: numericData
        }]
    },
    options: {
        title: {
            display: true,
            text: 'Project Statues'
        }
    }
});

function decodeHtml(html) {
    let txt = document.createElement("textarea");
    txt.innerHTML = html;
    return txt.value;
}
