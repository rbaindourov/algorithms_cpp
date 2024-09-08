function ReverseNumber( num ){
    let result = 0;
    while( num > 0 ){
        result = result * 10 + num % 10;
        num = Math.floor( num / 10 );
    }
    return result   
}

console.log( ReverseNumber(121233))