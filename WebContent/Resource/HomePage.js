
/*
var image1 = new Image();
image1.src = "../Images/1.jpg";
var image2 = new Image();
image2.src = "../Images/2.jpg";
var image3 = new Image();
image3.src = "../Images/3.jpg";
var image4 = new Image();
image4.src = "../Images/4.jpg";
var image5 = new Image();
image5.src = "../Images/5.jpg";
*/
var step=1;
function slideit()
{
    document.getElementById("slide").src = eval("image"+step+".src");
    step++;
    if(step>5)
        step=1;
    setTimeout("slideit()",4000);
}
slideit();