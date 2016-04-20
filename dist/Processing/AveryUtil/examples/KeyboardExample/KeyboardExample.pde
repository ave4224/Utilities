import averycowan.util.Keyboard;

void setup() {
  size(500,400);
  background(0);
  Keyboard.setup();
}

void draw() {
  stroke(255);
  fill(128);
  ellipse(mouseX, mouseY, 100, 100);
  for(char c = 'a'; c <= 'z'; c++){
    if(Keyboard.isDown(c)){
      System.out.print(c);
    }
  }
  System.out.println();
}