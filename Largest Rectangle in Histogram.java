class Solution {
    public int largestRectangleArea(int[] heights) {       
    
    
    int[] left = new int[heights.length];
    
    Stack<Integer> st = new Stack<Integer>();
    
    for(int i=0;i<heights.length;i++){
    
        
        if(st.empty())
            left[i]=1;
        else if(heights[st.peek()]<heights[i])
            left[i]=1;
        else{
            
            while(st.empty()==false && heights[st.peek()]>=heights[i])
                st.pop();
            
            if(st.empty())
                left[i]=i+1;
            else
                left[i]=i-st.peek();
            
        }
        st.push(i);
    }
    
       
    while(st.empty()==false)
        st.pop();
        
        
    
    
    int[] right = new int[heights.length];
    
    for(int i=heights.length-1;i>=0;i--){       
       
        
        if(st.empty())
            right[i]=1;
        else if(heights[st.peek()]<heights[i])
            right[i]=1;
        else{
            
            while(st.empty()==false && heights[st.peek()]>=heights[i])
                st.pop();
            
            if(st.empty())
                right[i]=heights.length-i;
            else
                right[i]=st.peek()-i;
            
        }
        st.push(i);
    }  

    
    int max=0;
        
    for(int i=0;i<heights.length;i++){
  
        if((left[i]+right[i]-1)*heights[i]>max)
            max=(left[i]+right[i]-1)*heights[i];
    }    
     
    
    return max;

    }
}
