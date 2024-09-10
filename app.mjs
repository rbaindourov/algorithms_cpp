import { createServer } from 'node:http';
import url from 'url';
import {inspect} from 'util'
import crypto from 'crypto'


const hostname = '127.0.0.1';
const port = 3000;


const isPrime = num => {
  for(let i = 2, s = Math.sqrt(num); i <= s; i++) {
      if(num % i === 0) return false;
  }
  return num > 1;
}


const testArray = [11,10,12,13,14,15,16,17, 18, 19,20, 1,2,3,4,5,6,7,8, 9, 20];


const server = createServer((req, res) => {
  //console.log( inspect(req) );
  const params = url.parse( req.url, true ).query;  
  console.debug( params )
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/plain');  
  console.log( crypto.checkPrime( BigInt( parseInt( params.prime ?? 0 )), (result)=>{    
    res.end( result )
  }));
  
});

 
server.listen(port, hostname, () => {
	debugger;
  console.log(`Server running at http://${hostname}:${port}/`);
}); 
