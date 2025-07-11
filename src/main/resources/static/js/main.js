function scrollLeftHandler() {
    document.getElementById("card-scroll-container").scrollBy({
      left: -300,
      behavior: 'smooth'
    });
  }

  function scrollRightHandler() {
    document.getElementById("card-scroll-container").scrollBy({
      left: 300,
      behavior: 'smooth'
    });
  }

  // Auto scroll every 2 seconds
  let autoScrollInterval;
  const container = document.getElementById("card-scroll-container");

  function startAutoScroll() {
    autoScrollInterval = setInterval(() => {
      if (container.scrollLeft + container.clientWidth >= container.scrollWidth - 1) {
        container.scrollTo({ left: 0, behavior: 'smooth' });
      } else {
        container.scrollBy({ left: 300, behavior: 'smooth' });
      }
    }, 2000);
  }

  function stopAutoScroll() {
    clearInterval(autoScrollInterval);
  }

  container.addEventListener('mouseenter', stopAutoScroll);
  container.addEventListener('mouseleave', startAutoScroll);

  startAutoScroll();
  
  
  
  
  
  
  
  