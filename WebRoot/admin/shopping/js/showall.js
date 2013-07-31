var isCreate = false;
function showMp(event,obj,text,newline,width){
var x = event.clientX+3 + "px";
var y = event.clientY-30 + "px";
var width = width;
if(!isCreate){
var newSpan = document.createElement("span");
newSpan.id = "ow_xl_test_view_mp";
newSpan.innerHTML = text;
newSpan.style.fontSize = '12px';
newSpan.style.fontStyle = 'normal';
newSpan.style.fontWeight = 'normal';
newSpan.style.textDecoration = 'none';
newSpan.style.color = '#000000';
newSpan.style.border = '1px solid #000000';
newSpan.style.background = '#CECECE';
newSpan.style.position = 'absolute';
newSpan.style.width = '300px';
newSpan.style.heigth = 'auto';
newSpan.style.top = y;
newSpan.style.left = x;
newSpan.style.zIndex = '1000';
newSpan.style.whiteSpace = 'normal';
newSpan.style.wordWrap = 'break-word';
newSpan.style.wordBreak = 'normal'; 
if(newline){
if(width==null)
width = 200;
newSpan.style.width = width;
}
obj.parentNode.appendChild(newSpan);
isCreate = true;
}
}
function hideMp(obj){
isCreate = false;
try{
var node = document.getElementById('ow_xl_test_view_mp');
node.parentNode.removeChild(node);
}catch(e){}
}