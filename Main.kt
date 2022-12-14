package tictactoe
fun readingString(): String{
    val reading: String = readln()
    return reading
}

fun isMoveCorrect (a: MutableList<MutableList<Char>>, moves: String, charToWrite:Char) {
    val usermove: String = moves
    if (usermove[1] != ' ') {
        println("You should enter numbers!")
    }
    val mutableListLine1 = usermove.substringBefore(" ").toInt()-1
    val mutableListLine2 = usermove.substringAfter(" ").toInt()-1
    if (mutableListLine1 < 0 || mutableListLine2 < 0 || mutableListLine1 > 2 || mutableListLine2 > 2) {
        println("Coordinates should be from 1 to 3!")
    } else if (a[mutableListLine1][mutableListLine2] == ' '
        && a[mutableListLine1][mutableListLine2] != 'X'
        && a[mutableListLine1][mutableListLine2] != 'O') {
        a[mutableListLine1][mutableListLine2] = charToWrite
    } else if(a[mutableListLine1][mutableListLine2] != ' ') {
        println("This cell is occupied! Choose another one!")
    }
}

fun readingTable(a: MutableList<MutableList<Char>>) {
    println("---------")
    println("| ${a[0][0]} ${a[0][1]} ${a[0][2]} |")
    println("| ${a[1][0]} ${a[1][1]} ${a[1][2]} |")
    println("| ${a[2][0]} ${a[2][1]} ${a[2][2]} |")
    println("---------")
}

fun readingResultsOfGame(mutablexo: MutableList<MutableList<Char>>): Boolean {
    var drawOrNot = 0
    for (x in 0 until 3) {
        if(mutablexo[x][0] == mutablexo[x][1] && mutablexo[x][1] == mutablexo[x][2]
            && mutablexo[x][0] != ' ' && mutablexo[x][1] != ' ' && mutablexo[x][2] != ' ') {
            println("${mutablexo[x][0]} wins")
            return true
        }
    }
    for (x in 0 until 3) {
        if(mutablexo[0][x] == mutablexo[1][x] && mutablexo[1][x] == mutablexo[2][x]
            && mutablexo[0][x] != ' ' && mutablexo[1][x] != ' ' && mutablexo[2][x] != ' ') {
            println("${mutablexo[0][x]} wins")
            return true
        }
    }
    if(mutablexo[0][0] == mutablexo[1][1] && mutablexo[1][1] == mutablexo[2][2]
        && mutablexo[0][0] != ' ' && mutablexo[1][1] != ' ' && mutablexo[2][2] != ' ') {
        println("${mutablexo[1][1]} wins")
        return true
    } else if(mutablexo[0][2] == mutablexo[1][1] && mutablexo[1][1] == mutablexo[2][0]
        && mutablexo[0][2] != ' ' && mutablexo[1][1] != ' ' && mutablexo[2][0] != ' ') {
        println("${mutablexo[1][1]} wins")
        return true
    }
    for (x in 0 until 3) {
        for (y in 0 until 3) {
            if (mutablexo[x][y] == ' ') {
                drawOrNot++
            }
        }
    }
    if (drawOrNot == 0) {
        println("Draw")
        return true
    } else {
        return false
    }
}

fun main() {
    println("---------")
    println("|       |")
    println("|       |")
    println("|       |")
    println("---------")
    var end = false
    var turn = 0
    var charToWrite: Char
    val mutablexo = mutableListOf(
        mutableListOf<Char>(' ', ' ', ' '),
        mutableListOf<Char>(' ', ' ', ' '),
        mutableListOf<Char>(' ', ' ', ' ')
    )
    while (end == false) {
        if (turn%2==0){
            charToWrite='O'
        } else {
            charToWrite = 'X'
        }
        val readyStringToUse = readingString()
        isMoveCorrect(mutablexo, readyStringToUse, charToWrite)
        readingTable(mutablexo)
        end = readingResultsOfGame(mutablexo, )
        turn++
    }
}
