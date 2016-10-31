package com.telenav.playground.commander.permission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link GetSocialConnections}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableGetSocialConnections.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "GetSocialConnections"})
final class ImmutableGetSocialConnections
    implements GetSocialConnections {
  private final SocialAccount socialAccount;

  private ImmutableGetSocialConnections(SocialAccount socialAccount) {
    this.socialAccount = socialAccount;
  }

  /**
   * @return The value of the {@code socialAccount} attribute
   */
  @Override
  public SocialAccount socialAccount() {
    return socialAccount;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link GetSocialConnections#socialAccount() socialAccount} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for socialAccount
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableGetSocialConnections withSocialAccount(SocialAccount value) {
    if (this.socialAccount == value) return this;
    SocialAccount newValue = Objects.requireNonNull(value, "socialAccount");
    return new ImmutableGetSocialConnections(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableGetSocialConnections} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableGetSocialConnections
        && equalTo((ImmutableGetSocialConnections) another);
  }

  private boolean equalTo(ImmutableGetSocialConnections another) {
    return socialAccount.equals(another.socialAccount);
  }

  /**
   * Computes a hash code from attributes: {@code socialAccount}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + socialAccount.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code GetSocialConnections} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "GetSocialConnections{"
        + "socialAccount=" + socialAccount
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link GetSocialConnections} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable GetSocialConnections instance
   */
  public static ImmutableGetSocialConnections copyOf(GetSocialConnections instance) {
    if (instance instanceof ImmutableGetSocialConnections) {
      return (ImmutableGetSocialConnections) instance;
    }
    return ImmutableGetSocialConnections.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableGetSocialConnections ImmutableGetSocialConnections}.
   * @return A new ImmutableGetSocialConnections builder
   */
  public static ImmutableGetSocialConnections.Builder builder() {
    return new ImmutableGetSocialConnections.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableGetSocialConnections ImmutableGetSocialConnections}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  static final class Builder {
    private static final long INIT_BIT_SOCIAL_ACCOUNT = 0x1L;
    private long initBits = 0x1L;

    private SocialAccount socialAccount;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code GetSocialConnections} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(GetSocialConnections instance) {
      Objects.requireNonNull(instance, "instance");
      socialAccount(instance.socialAccount());
      return this;
    }

    /**
     * Initializes the value for the {@link GetSocialConnections#socialAccount() socialAccount} attribute.
     * @param socialAccount The value for socialAccount 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder socialAccount(SocialAccount socialAccount) {
      this.socialAccount = Objects.requireNonNull(socialAccount, "socialAccount");
      initBits &= ~INIT_BIT_SOCIAL_ACCOUNT;
      return this;
    }

    /**
     * Builds a new {@link ImmutableGetSocialConnections ImmutableGetSocialConnections}.
     * @return An immutable instance of GetSocialConnections
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableGetSocialConnections build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableGetSocialConnections(socialAccount);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_SOCIAL_ACCOUNT) != 0) attributes.add("socialAccount");
      return "Cannot build GetSocialConnections, some of required attributes are not set " + attributes;
    }
  }

  /**
   * Immutable implementation of {@link GetSocialConnections.R}.
   * <p>
   * Use the builder to create immutable instances:
   * {@code ImmutableGetSocialConnections.R.builder()}.
   */
  public static final class R implements GetSocialConnections.R {
    private final List<SocialConnection> connections;

    private R(List<SocialConnection> connections) {
      this.connections = connections;
    }

    /**
     * @return The value of the {@code connections} attribute
     */
    @Override
    public List<SocialConnection> connections() {
      return connections;
    }

    /**
     * Copy the current immutable object with elements that replace the content of {@link GetSocialConnections.R#connections() connections}.
     * @param elements The elements to set
     * @return A modified copy of {@code this} object
     */
    public final ImmutableGetSocialConnections.R withConnections(SocialConnection... elements) {
      List<SocialConnection> newValue = createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
      return new ImmutableGetSocialConnections.R(newValue);
    }

    /**
     * Copy the current immutable object with elements that replace the content of {@link GetSocialConnections.R#connections() connections}.
     * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
     * @param elements An iterable of connections elements to set
     * @return A modified copy of {@code this} object
     */
    public final ImmutableGetSocialConnections.R withConnections(Iterable<? extends SocialConnection> elements) {
      if (this.connections == elements) return this;
      List<SocialConnection> newValue = createUnmodifiableList(false, createSafeList(elements, true, false));
      return new ImmutableGetSocialConnections.R(newValue);
    }

    /**
     * This instance is equal to all instances of {@code R} that have equal attribute values.
     * @return {@code true} if {@code this} is equal to {@code another} instance
     */
    @Override
    public boolean equals(Object another) {
      if (this == another) return true;
      return another instanceof ImmutableGetSocialConnections.R
          && equalTo((ImmutableGetSocialConnections.R) another);
    }

    private boolean equalTo(ImmutableGetSocialConnections.R another) {
      return connections.equals(another.connections);
    }

    /**
     * Computes a hash code from attributes: {@code connections}.
     * @return hashCode value
     */
    @Override
    public int hashCode() {
      int h = 31;
      h = h * 17 + connections.hashCode();
      return h;
    }

    /**
     * Prints the immutable value {@code R} with attribute values.
     * @return A string representation of the value
     */
    @Override
    public String toString() {
      return "R{"
          + "connections=" + connections
          + "}";
    }

    /**
     * Creates an immutable copy of a {@link GetSocialConnections.R} value.
     * Uses accessors to get values to initialize the new immutable instance.
     * If an instance is already immutable, it is returned as is.
     * @param instance The instance to copy
     * @return A copied immutable R instance
     */
    public static ImmutableGetSocialConnections.R copyOf(GetSocialConnections.R instance) {
      if (instance instanceof ImmutableGetSocialConnections.R) {
        return (ImmutableGetSocialConnections.R) instance;
      }
      return ImmutableGetSocialConnections.R.builder()
          .from(instance)
          .build();
    }

    /**
     * Creates a builder for {@link ImmutableGetSocialConnections.R R}.
     * @return A new R builder
     */
    public static ImmutableGetSocialConnections.R.Builder builder() {
      return new ImmutableGetSocialConnections.R.Builder();
    }

    /**
     * Builds instances of type {@link ImmutableGetSocialConnections.R R}.
     * Initialize attributes and then invoke the {@link #build()} method to create an
     * immutable instance.
     * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
     * but instead used immediately to create instances.</em>
     */
    public static final class Builder {
      private List<SocialConnection> connections = new ArrayList<SocialConnection>();

      private Builder() {
      }

      /**
       * Fill a builder with attribute values from the provided {@code R} instance.
       * Regular attribute values will be replaced with those from the given instance.
       * Absent optional values will not replace present values.
       * Collection elements and entries will be added, not replaced.
       * @param instance The instance from which to copy values
       * @return {@code this} builder for use in a chained invocation
       */
      public final Builder from(GetSocialConnections.R instance) {
        Objects.requireNonNull(instance, "instance");
        addAllConnections(instance.connections());
        return this;
      }

      /**
       * Adds one element to {@link GetSocialConnections.R#connections() connections} list.
       * @param element A connections element
       * @return {@code this} builder for use in a chained invocation
       */
      public final Builder addConnections(SocialConnection element) {
        this.connections.add(Objects.requireNonNull(element, "connections element"));
        return this;
      }

      /**
       * Adds elements to {@link GetSocialConnections.R#connections() connections} list.
       * @param elements An array of connections elements
       * @return {@code this} builder for use in a chained invocation
       */
      public final Builder addConnections(SocialConnection... elements) {
        for (SocialConnection element : elements) {
          this.connections.add(Objects.requireNonNull(element, "connections element"));
        }
        return this;
      }

      /**
       * Sets or replaces all elements for {@link GetSocialConnections.R#connections() connections} list.
       * @param elements An iterable of connections elements
       * @return {@code this} builder for use in a chained invocation
       */
      public final Builder connections(Iterable<? extends SocialConnection> elements) {
        this.connections.clear();
        return addAllConnections(elements);
      }

      /**
       * Adds elements to {@link GetSocialConnections.R#connections() connections} list.
       * @param elements An iterable of connections elements
       * @return {@code this} builder for use in a chained invocation
       */
      public final Builder addAllConnections(Iterable<? extends SocialConnection> elements) {
        for (SocialConnection element : elements) {
          this.connections.add(Objects.requireNonNull(element, "connections element"));
        }
        return this;
      }

      /**
       * Builds a new {@link ImmutableGetSocialConnections.R R}.
       * @return An immutable instance of R
       * @throws java.lang.IllegalStateException if any required attributes are missing
       */
      public ImmutableGetSocialConnections.R build() {
        return new ImmutableGetSocialConnections.R(createUnmodifiableList(true, connections));
      }
    }
  }

  private static <T> List<T> createSafeList(Iterable<? extends T> iterable, boolean checkNulls, boolean skipNulls) {
    ArrayList<T> list;
    if (iterable instanceof Collection<?>) {
      int size = ((Collection<?>) iterable).size();
      if (size == 0) return Collections.emptyList();
      list = new ArrayList<T>();
    } else {
      list = new ArrayList<T>();
    }
    for (T element : iterable) {
      if (skipNulls && element == null) continue;
      if (checkNulls) Objects.requireNonNull(element, "element");
      list.add(element);
    }
    return list;
  }

  private static <T> List<T> createUnmodifiableList(boolean clone, List<T> list) {
    switch(list.size()) {
    case 0: return Collections.emptyList();
    case 1: return Collections.singletonList(list.get(0));
    default:
      if (clone) {
        return Collections.unmodifiableList(new ArrayList<T>(list));
      } else {
        if (list instanceof ArrayList<?>) {
          ((ArrayList<?>) list).trimToSize();
        }
        return Collections.unmodifiableList(list);
      }
    }
  }
}
