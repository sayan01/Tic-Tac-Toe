var arr,sc,size;
var player1turn;
var gameover;
var count;
var winner;
var button;
function setup() {
    size = 600;
    player1turn = true;
    gameover = false;
    count = 0;

    sc = size/3;
    createCanvas(size,size);

    button = createButton('reset',5);
    button.position(220, 650);
    button.size(170,100);
    button.style('font-size','300%');
    button.mouseReleased(function()
        {location.reload();
    });

    arr = [1,2,3,4,5,6,7,8,9];
}

function draw() {
    background(51);
    for(i = 0;i < 9; i++){
        fill(51);
        strokeWeight(3);
        stroke(255);
        push();
        translate(((i%3)*sc),(floor((i/3))*sc));
        rect(0,0,sc,sc);
        if(arr[i] == 0){
            ellipse(sc/2, sc/2, sc/2, sc/2);
        }
        else if(arr[i] == -1){
            line(sc/4, sc/4, 3 * (sc/4),3 * (sc/4));
            line(3 * (sc/4), (sc/4), (sc/4), 3 * (sc/4));
        }
        pop();
    }
    if(gameover){
        //Draw the line
        x1 = (winner[0]%3)*sc + sc/2;
        y1 = (floor(winner[0]/3))*sc + sc/2;
        x2 = (winner[1]%3)*sc + sc/2;
        y2 = (floor(winner[1]/3))*sc + sc/2;
        strokeWeight(20);
        line(x1, y1, x2, y2);
    }
}

function mouseReleased(){
    if(gameover){   return; }
    mx = mouseX;
    my = mouseY;
    if(mx>size || my>size ){   return; }
    x = floor(mx/sc);
    y = floor(my/sc);
    ind = (y*3) + x;
    if(arr[ind]<=0){return;}
    arr[ind] = (player1turn)?-1:0;
    player1turn = !player1turn;
    checkwon();
}

function keyPressed(){
    if(key === 'R'){
		location.reload();
	}
}

function checkwon(){
    if(count === 9) {
        gameover= true;
    }
	for( i = 0;i < 3;i++){
		if(arr[i] === (arr[i+3]) && arr[i] === (arr[i+6])){
            gameover = true;
            winner = [i,i+6];
		}
	}


	for( i =0;i<9;i+=3){
		if(arr[i] === (arr[i+1]) && arr[i] === (arr[i+2])){
            gameover = true;
            winner = [i,i+2];
		}
	}

	for( i = 0, b = 4; i < 3; i += 2, b -= 2){
		if(arr[i] === (arr[i+b]) && arr[i] === (arr[i+b+b])){
            gameover = true;
            winner = [i,i+b+b];
		}
	}
}