public void move(int num) {
num %= w * 2 + h * 2 - 4;
if (num == 0) num = w * 2 + h * 2 - 4;
for (int i = 0; i < num; i++) {
switch (dir) {
case "East":
if (x == w - 1) {
dir = "North";
y++;
}
else {
x++;
}
break;
case "North":
if (y == h - 1) {
dir = "West";
x--;
}
else {
y++;
}
break;
case "West":
if (x == 0) {
dir = "South";
y--;
}
else {
x--;
}
break;
case "South":
if (y == 0) {
dir = "East";
x++;
}
else {
y--;
}
}
}
}