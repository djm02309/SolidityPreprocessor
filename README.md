# SolidityPreprocessor

This project is related to the preprocessor that rewrites solidity code. 
Provide the user with the keyword nonfallback so that the user can indicate that the fallback function should not be called. 
When the user displays the intention using the keyword, it uses the if condition statement to check the status variable and informs the user whether to call the fallback function.
The preprocessor adds new contracts and state variables to know if the fallback function is called.

Example) A Sol source file (including "NONFALLBACK" keyword)
<pre><code>
contract Caller {
    function callTest(Test test) public {
        test.call(0xabcdef01 , NONFALLBACK); // hash does not exist
    }
}
</code></pre>

The code above will look like the code below after passing through the preprocessor.

<pre><code>
contract Caller {
    function callTest(Test test) public {
        forFallback ffb = new forFallback();
        test.call(0xabcdef01 , NONFALLBACK); // hash does not exist
        if(ffb.getData = 1){
          throw;
        }
    }
}
contract forFallback {
  uint private getfb = 0;
  function setData(uint a) public { getfb = a; }
  function getData() public returns(uint) { return getfb; }
}
</code></pre>

For more details, please contact us.
