import { EventEmitter } from 'events';
import { performance } from 'perf_hooks';
import assert from 'assert';

interface OrderDetails {
  id: string;
  customerName: string;
  items: string[];
  total: number;
}

class Order extends EventEmitter {
  private details: OrderDetails;

  constructor(details: OrderDetails) {
    super();
    this.details = details;
  }

  updateTotal(newTotal: number) {
    this.details.total = newTotal;
    this.emit('totalUpdated', newTotal);
  }

  addItem(item: string) {
    this.details.items.push(item);
    this.emit('itemAdded', item);
  }

  getOrderDetails(): OrderDetails {
    return { ...this.details };
  }
}

export default Order;


function performanceTestOrder() {
  const startTime = performance.now();

  // Create a large number of orders
  const numOrders = 10000;
  const orders = [];

  for (let i = 0; i < numOrders; i++) {
    const order = new Order({
      id: `order${i}`,
      customerName: `Customer ${i}`,
      items: [`Item ${i}`],
      total: 100
    });

    orders.push(order);

    // Perform some operations
    order.addItem(`Additional Item ${i}`);
    order.updateTotal(150);
    order.getOrderDetails();
  }

  const endTime = performance.now();
  const duration = endTime - startTime;

  console.log(`Created and manipulated ${numOrders} orders in ${duration.toFixed(2)} ms`);
  
  // Assert that the performance is within acceptable limits
  assert(duration < 1000, `Performance test failed. Expected < 1000 ms, but took ${duration.toFixed(2)} ms`);
}

performanceTestOrder();
