/*

function takes a total and a container id.

Clones the total template, sets the value of the total and appends it to the container

 */

function setTotal(total, containerId){

    console.log("set total");
    var totalTemplate = $('.total-template .total');
    console.log ("get template: ", totalTemplate);
    var container=$(containerId);
    console.log("Get container: ", container);
    container.empty();
    var totalValue=totalTemplate.clone();
    totalValue.find("h1").text("£" + total);
    console.log("new total H1: ", totalValue);
    totalValue.appendTo(container);

}

/*
*
* Takes an array of activities and a container id
* Clones the template for the table and appends to the container
* Then calls sub-function to clone <tr> template for each activity
*
* */

function setActivities(activities, containerId){
    console.log('Adding table to div ', containerId);
    var tableTemplate = $('.activity-table-template .activity-table');
    var container = $(containerId);
    container.empty();
    var newActivityTable = tableTemplate.clone().appendTo(container);
    console.log ("table added, now iterate and add table rows");
    activities.forEach(function (activity) {
        setActivityDetail(activity, newActivityTable.find("tbody"))
    });
}

/**
 *
 * @param activity
 * @param aContainer
 *
 * Takes the activity and the container (not the containerId), and clones the activity template "<tr>"
 * Then injects each property into the <td> fields, and appends each <tr> to the containing <tbody>
 *
 */

function setActivityDetail(activity, aContainer) {

    console.log("add activity: ", activity);
    console.log("to: ", aContainer);


    var detailTemplate = $('#activity-row-template tr');

    var newActivity = detailTemplate.clone();

    console.log (newActivity);

    newActivity.find(".who").text(activity.who);
    newActivity.find(".what").text(activity.what);
    newActivity.find(".when").text(activity.when.dayOfMonth + " " + activity.when.month);
    aContainer.append(newActivity);

}