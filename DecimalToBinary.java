class StackADT 
{
    int maxSize;
    int[] stackArray;
    int top;

    public StackADT(int maxSize) 
	{
        this.maxSize = maxSize;
        this.stackArray = new int[maxSize];
        this.top = -1; // Initialize the top of the stack to -1 (empty)
    }

    public boolean isEmpty() 
	{
        return top == -1;
    }

    public boolean isFull() 
	{
        return top == maxSize - 1;
    }

    public void push(int data) 
	{
        if (isFull()) 
		{
            System.out.println("Stack is full. Cannot push " + data);
        } 
		else 
		{
            stackArray[++top] = data;
        }
    }

    public int pop() 
	{
        if (isEmpty()) 
		{
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        } 
		else 
		{
			/*
            int data = stackArray[top];
            top--;
            return data;
			*/
			return stackArray[top--];
        }
    }

    public int peek() 
	{
        if (isEmpty()) 
		{
            System.out.println("Stack is empty.");
            return -1;
        } 
		else 
		{
            return stackArray[top];
        }
    }

    public void display() 
	{
        if (isEmpty()) 
		{
            System.out.println("Stack is empty.");
        } 
		else 
		{
            System.out.print("Stack: ");
            for (int i = top; i >= 0; i--) 
			{
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }
	
}

public class DecimalToBinary 
{
    public static void main(String[] args) 
	{
        int decimal = 47; // Example decimal number
        StackADT stack = new StackADT(32); // Enough size for binary of int

        int num = decimal;
        while (num > 0) 
		{
            stack.push(num % 2); // Store remainder
            num = num / 2;
        }

        System.out.print("Binary of " + decimal + " = ");
        while (!stack.isEmpty()) 
		{
            System.out.print(stack.pop()); // Pop in reverse order
        }
        System.out.println();
    }
}
