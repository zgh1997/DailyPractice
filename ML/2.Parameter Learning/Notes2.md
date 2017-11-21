## 2.1 Gradient Descent
微积分多元函数求极值的梯度下降法部分。

已知 ${J(\theta_0,\theta_1,...,\theta_n)}$

求解 ${\min J(\theta_0,\theta_1,...,\theta_n)}$

### 梯度下降算法：
$$
\theta_j := \theta_j - \alpha \frac{\partial}{\partial \theta_j} J(\theta_0, \theta_1)
$$

**注意事项：**
必须同步更新各个参数 ${\theta}$
![Notice](./gd_warning.png)
