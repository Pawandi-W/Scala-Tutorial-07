class Rational (x: Int, y: Int) {
  def num = x
  def den = y
  def neg () = { // Q1
    new Rational(- this.num, this.den)
  }
  def sub (r:Rational) = { // Q2
    new Rational ((this.num * r.den) - (r.num * this.den), (this.den * r.den))
  }
  def out () ={
    println(this.num,this.den);
  }
}

val x = new Rational(3,4);
val y = new Rational (5,8);
val z = new Rational (2,7);

x.neg.out;
x.sub(y).sub(z).out;
