$(document).ready(

    function () {
        $("#form-div").hide();
        $("#btn-course").click(getCourse);
        $("#btn-student").click(getStudents);

        function addCourse() {
            $("#form-div").show();
            const courseData= {
                id: document.getElementById("#id").value,
                name: document.getElementById("#name").value,
                courseCode: document.getElementById("#courseCode").value
            }
            fetch('http://localhost:8082/courses',{
                method: 'POST',
                headers:{
                    'contentType' : 'application/json',
                },
                body: JSON.stringify(courseData)
            })
                .then(response => {
                    if(!response.ok){
                        throw new Error('Request failed')
                    }
                    return response;
                })
                .catch(error =>{
                    console.error(err);
                })
        }

        $("#btn-addCourse").click(addCourse);
    });






function getCourse() {

    const url = `http://localhost:8082/courses`;
    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error('Error: ' + response.status);
            }
            return response.json();
        })
        .then(courses => {
            populateCourseList(courses);
        })
        .catch(err => {
            console.log(err)
        })
    function populateCourseList(courseArray) {
        let ul = $("#courseList");
        for (let i = 0; i < courseArray.length; i++) {
            let li = $("<li>").text(courseArray[i].name);
            ul.append(li);
        }
    }
}



function getStudents() {

    const url = `http://localhost:8082/students`;
    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error('Error: ' + response.status);
            }
            return response.json();
        })
        .then(students => {
            console.log(students);
            populateStudentList(students);
        })
        .catch(err => {
            console.log(err)
        })

    function populateStudentList(studentArray) {
        let ul = $("#courseList");
        for (let i = 0; i < studentArray.length; i++) {
            let li = $("<li>").text(studentArray[i].firstName + " " + studentArray[i].lastName);

            ul.append(li);
        }
    }


}



